package storitz

println "Refreshing inventory"

// TODO: refactor these scripts into one script
def sources = ['QS', 'SL','CS3', 'USI', 'DOM', 'STM']

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

StoritzGroovyUtil.validatePromos(100,true)
