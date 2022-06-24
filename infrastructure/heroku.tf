resource "heroku_app" "everythingxrm_staging" {
  name   = "everythingxrm-staging"
  region = "eu"

  buildpacks = [
    "heroku/gradle"
  ]
}

resource "heroku_addon" "everythingxrm_staging_db" {
  app  = heroku_app.everythingxrm_staging.id
  plan = "heroku-postgresql:hobby-dev"
}


resource "heroku_pipeline" "everythingxrm_pipeline" {
  name = "everythingxrm-pipeline"
}

# Couple app to pipeline.
resource "heroku_pipeline_coupling" "staging_pipeline_coupling" {
  app      = heroku_app.everythingxrm_staging.id
  pipeline = heroku_pipeline.everythingxrm_pipeline.id
  stage    = "staging"
}


// Add the GitHub repository integration with the pipeline.
resource "herokux_pipeline_github_integration" "pipeline_integration" {
  pipeline_id = heroku_pipeline.everythingxrm_pipeline.id
  org_repo = "utrost/EverythingXRM"
}

// Add Heroku app GitHub integration.
resource "herokux_app_github_integration" "everything_gh_integration" {
  app_id = heroku_app.everythingxrm_staging.uuid
  branch = "master"
  auto_deploy = true
  wait_for_ci = true

  # Tells Terraform that this resource must be created/updated
  # only after the `herokux_pipeline_github_integration` has been successfully applied.
  depends_on = [herokux_pipeline_github_integration.pipeline_integration]
}