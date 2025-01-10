def call(){

    def build = currentBuild.build()
    def actions = build.actions

    def tableData = [
        ['Suite Name', 'Passed', 'Failed', 'Total', 'Pass %']
    ]
                        
    actions.each() { action ->
        if( action.class.simpleName.equals("RobotBuildAction") ) { 
            def row = [
                action.getxAxisLabel(),
                action.getTotalCount() - action.getFailCount(),
                action.getFailCount(),
                action.getTotalCount(),
                action.getOverallPassPercentage()
            ]
            tableData.add(row)
        }
    }

    if (tableData.size() == 1) {
        tableData.add(['No Robot Framework test results found.', '', '', '', ''])
    } 

    def tableString = formatTableData(tableData)
    println tableString
    return tableString
}


def formatTableData(tableData) {
    def tableString = ''
    tableData.each { row ->
        tableString += row.join(' | ') + '\n'
    }
    return tableString
}