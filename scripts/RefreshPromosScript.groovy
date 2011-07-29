package storitz

println "Refreshing promotions"

// JM: QS placed first to reduce javax/activation/DataHandler linker errors
def sources = ['QS','SL','CS3','USI']

for (int i = 0; i < sources.size(); i++) {
    def src = sources[i]
    try {
        println "Refreshing ${src}"
        RefreshPromos rp = new RefreshPromos();
        rp.execute(new LocalContext('Admin', src));
        println "Refreshing complete!"
    }
    catch (Exception e) {
        println("Error refreshing promotions!")
        e.printStackTrace()
    }
}

StoritzGroovyUtil.validatePromos(100,true)
