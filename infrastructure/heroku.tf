resource "heroku_app" "everythingxrm_staging" {
  name   = "everythingxrm-staging"
  region = "eu"

  buildpacks = [
    "heroku/gradle"
  ]
}