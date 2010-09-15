authorizeNet {
    testMode = false
    duplicateWindow = '120'  //Default is 120 (2 minutes)
    delimiter = ';'
}

environments {
    development {
        authorizeNet {
            login = '2E3jsfH7L5F'
            transactionKey = '979cxZC5g8dDRf9b'
            urlString = 'https://test.authorize.net/gateway/transact.dll'
        }
    }
    preview {
        authorizeNet {
            login = '2E3jsfH7L5F'
            transactionKey = '979cxZC5g8dDRf9b'
            urlString = 'https://test.authorize.net/gateway/transact.dll'
        }
    }
    test {
        authorizeNet {
            login = '2E3jsfH7L5F'
            transactionKey = '979cxZC5g8dDRf9b'
            urlString = 'https://test.authorize.net/gateway/transact.dll'
        }
    }
    production {
        authorizeNet {
            login = '92c4zN6Xj'
            transactionKey = '9764C6T9DtAmU9uD'
            urlString = 'https://secure.authorize.net/gateway/transact.dll'
        }
    }
}

