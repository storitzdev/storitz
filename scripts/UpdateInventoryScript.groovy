package storitz

class LocalContext {
    def mergedJobDataMap

    LocalContext(name, src) {
        mergedJobDataMap = [from : name , source : src ]
    }
}

println "Refreshing inventory"

 // JM: QS placed first to reduce javax/activation/DataHandler linker errors
def sources = ['QS','SL','CS3','EX','USI']

for (int i = 0; i < sources.size(); i++) {
    def src = sources[i]
    try {
        println "Refreshing ${src}"
        UpdateInventory ui = new UpdateInventory();
        ui.execute(new LocalContext('Admin', src));
        println "Refreshing complete!"
    }
    catch (Exception e) {
        println("Error refreshing inventory!")
        e.printStackTrace()
    }
}

