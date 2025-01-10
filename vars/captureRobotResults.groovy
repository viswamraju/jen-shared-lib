def call(){

    def build = currentBuild.build()
    def actions = build.actions
                        
    actions.each() { action ->
        if( action.class.simpleName.equals("RobotBuildAction") ) { 

            def passCount = action.getTotalCount() - action.getFailCount()
            println "Suite Name: ${action.getxAxisLabel()}"
            println "TotalCount: ${action.getTotalCount()}"
            println "FailCount: ${action.getFailCount()}"
            println "PassCount: ${passCount}"
            println "PassPercentage: ${action.getOverallPassPercentage()}"
        }
    }
    
}