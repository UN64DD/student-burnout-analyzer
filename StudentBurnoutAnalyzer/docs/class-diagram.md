+--------------------------------------------------+
|                <<abstract>> Activity             |
+--------------------------------------------------+
| # hours : double                                 |
+--------------------------------------------------+
| + Activity(hours : double)                       |
| + getHours() : double                            |
| + setHours(hours : double) : void                |
| + calculateImpact() : double                     |
+--------------------------------------------------+
            ^                ^                ^
            |                |                |
            | extends        | extends        | extends
            |                |                |
+----------------+  +----------------+  +----------------+
| StudyActivity  |  | SleepActivity  |  | ExerciseActivity|
+----------------+  +----------------+  +----------------+
| +calculateImpact()| | +calculateImpact()| |+calculateImpact()|
+----------------+  +----------------+  +----------------+


+--------------------------------------------------+
|                  DailyRecord                     |
+--------------------------------------------------+
| - studyHours : double                            |
| - sleepHours : double                            |
| - exerciseHours : double                         |
| - assignmentCount : int                          |
| - burnoutScore : double                          |
| - riskLevel : String                             |
+--------------------------------------------------+
| + getters/setters                                |
| + toString() : String                            |
+--------------------------------------------------+


+--------------------------------------------------+
|               BurnoutCalculator                  |
+--------------------------------------------------+
| - MAX_SCORE : double                             |
+--------------------------------------------------+
| + calculateBurnout(record) : double              |
| + calculateBurnout(studyHours) : double          |
| + calculateBurnout(studyHours,sleepHours):double |
| + determineRiskLevel(score) : String             |
+--------------------------------------------------+
                    |
                    | uses
                    v
               DailyRecord


+--------------------------------------------------+
|             RecommendationEngine                 |
+--------------------------------------------------+
| + generateRecommendation(record) : String        |
+--------------------------------------------------+
                    |
                    | uses
                    v
               DailyRecord


+--------------------------------------------------+
|              ValidationUtil                      |
+--------------------------------------------------+
| - MAX_HOURS : double                             |
| - MAX_ASSIGNMENTS : int                          |
+--------------------------------------------------+
| + validateHours(hours) : void                    |
| + validateAssignments(count) : void              |
+--------------------------------------------------+
                    |
                    | throws
                    v

+--------------------------------------------------+
|             InvalidHoursException                |
+--------------------------------------------------+
| + InvalidHoursException(message)                 |
+--------------------------------------------------+


+--------------------------------------------------+
|                HistoryManager                    |
+--------------------------------------------------+
| + saveRecord(record) : void                      |
| + loadRecords() : List<DailyRecord>              |
+--------------------------------------------------+
                    |
                    | uses
                    v

+--------------------------------------------------+
|                    CSVUtil                       |
+--------------------------------------------------+
| + writeCSV(...) : void                           |
| + readCSV(...) : List<DailyRecord>               |
+--------------------------------------------------+


====================================================
                    GUI LAYER
====================================================

+--------------------------------------------------+
|                  MainFrame                       |
+--------------------------------------------------+
| + MainFrame()                                    |
| - initComponents()                               |
| - handleNewRecord()                              |
| - handleViewAnalysis()                           |
| - handleExit()                                   |
+--------------------------------------------------+
                    |
                    | contains
                    v

+--------------------------------------------------+
|                  RecordForm                      |
+--------------------------------------------------+
| - studyField : JTextField                        |
| - sleepField : JTextField                        |
| - exerciseField : JTextField                     |
| - assignmentSpinner : JSpinner                   |
| - saveButton : JButton                           |
| - analyzeButton : JButton                        |
+--------------------------------------------------+
| - handleSave()                                   |
| - handleAnalyze()                                |
| - determineRiskLevel()                           |
| - buildResultText()                              |
+--------------------------------------------------+
     |               |                |
     | uses          | uses           | uses
     v               v                v

 ValidationUtil  BurnoutCalculator  RecommendationEngine

                    |
                    | creates
                    v

               DailyRecord

                    |
                    | opens
                    v

+--------------------------------------------------+
|                AnalysisFrame                     |
+--------------------------------------------------+
| - resultArea : JTextArea                         |
+--------------------------------------------------+
| + displayResults(result)                         |
+--------------------------------------------------+


+--------------------------------------------------+
|                     Main                         |
+--------------------------------------------------+
| + main(String[])                                 |
+--------------------------------------------------+
                    |
                    | launches
                    v

               MainFrame