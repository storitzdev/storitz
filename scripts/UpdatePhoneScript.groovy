package storitz

println "Refreshing phones"

// JM: QS placed first to reduce javax/activation/DataHandler linker errors
def sources = ['QS', 'SL','CS3', 'EX', 'USI']

for (int i = 0; i < sources.size(); i++) {
    def src = sources[i]
    try {
        println "Refreshing ${src}"
        RefreshPhone rp = new RefreshPhone();
        rp.execute(new LocalContext('Admin', src));
        println "Refreshing complete!"
    }
    catch (Exception e) {
        println("Error refreshing phones!")
        e.printStackTrace()
    }
}

