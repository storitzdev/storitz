recaptcha {
  // These keys are generated by the ReCaptcha service
  publicKey = "6LectQcAAAAAAAu1xg8CzP8MnzweNnOndSaz53HZ"
  privateKey = "6LectQcAAAAAAHmRrfYaHAitQ1gzxfpUTWDNhgQS"

  // Include the noscript tags in the generated captcha
  includeNoScript = true
}

environments {
  development {
    recaptcha {
      // Set to false to disable the display of captcha
      enabled = true

      // Communicate using HTTPS
      useSecureAPI = false
    }
  }
  production {
    recaptcha {
      // Set to false to disable the display of captcha
      enabled = true

      // Communicate using HTTPS
      useSecureAPI = true
    }
  }
}