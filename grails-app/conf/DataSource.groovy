dataSource {
  pooled = true
  driverClassName = "org.hsqldb.jdbcDriver"
  username = "sa"
  password = ""
}
hibernate {
  cache.use_second_level_cache = true
  cache.use_query_cache = true
  cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
  max_fetch_depth = 5
}
// environment specific settings
environments {
  development {
    dataSource {
      dbCreate = "update" // one of 'create', 'create-drop','update'
      url = "jdbc:hsqldb:file:devDB"
      //loggingSql = true
    }
  }
  development_script {
    dataSource {
      dbCreate = "update" // one of 'create', 'create-drop','update'
      url = "jdbc:hsqldb:file:devDB"
      //loggingSql = true
    }
  }
  preview {
    dataSource {
      dbCreate = "update" // one of 'create', 'create-drop','update'
      jndiName = "java:comp/env/jdbc/storitz_preview"
      //loggingSql = true
    }
  }
  preview_script {
    dataSource {
      dbCreate = "update" // one of 'create', 'create-drop','update'
      jndiName = "java:comp/env/jdbc/storitz_preview"
      //loggingSql = true
    }
  }
  test {
    dataSource {
      dbCreate = "update" // one of 'create', 'create-drop','update'
      jndiName = "java:comp/env/jdbc/storitz_test"
      //loggingSql = true
    }
  }
  test_script {
     dataSource {
        dbCreate = "update" // one of 'create', 'create-drop','update'
        jndiName = "java:comp/env/jdbc/storitz_test"
        //loggingSql = true
     }
  }
  production {
    dataSource {
      dbCreate = "update"
      jndiName = "java:comp/env/jdbc/storitz"
    }
  }
  production_script {
    dataSource {
      dbCreate = "update"
      jndiName = "java:comp/env/jdbc/storitz"
    }
  }
}
