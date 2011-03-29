package storitz

println "Refreshing inventory"

def sources = ['EX']

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

