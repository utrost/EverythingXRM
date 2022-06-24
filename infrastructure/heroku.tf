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
