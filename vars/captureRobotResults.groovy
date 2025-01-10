def call(){

    def build = currentBuild.build()
    def actions = build.actions
                        
    actions.each() { action ->
        if( action.class.simpleName.equals("RobotBuildAction") ) { 
            println "Suite Name: ${action.getxAxisLabel()}"
            println "TotalCount: ${action.getTotalCount()}"
            println "FailCount: ${action.getFailCount()}"
            println "PassCount: ${action.getTotalCount()}-${action.getTotalCount()}"
            println "PassPercentage: ${action.getOverallPassPercentage()}"
        }
    }
    
}