package classes.config;

public class CResource {
    /* Scene FXML Files */
    public static final String FXML_MAIN_WINDOW = "/scenes/MainWindow.fxml";

    /* Topics and Questions */
    public static final String[][] checklistResources =
            {
                    {"Strategy/Alignment", "What specific organization strategy does this project align with?"},
                    {"Driver", "What business problem does the project solve?"},
                    {"Success Metrics", "How will measure success?"},
                    {"Sponsorship", "Who is the project sponsor?"},
                    {"Risk", "What is the impact of not doing this project?"},
                    {"Risk", "What is the project risk to our organization?"},
                    {"Risk", "Where does the proposed project fit in our risk profile?"},
                    {"Benefits, value", "What is the value of the project organization?"},
                    {"Benefits, value", "When will the project shows results?"},
                    {"Objectives", "What are the project objectives?"},
                    {"Organization Culture", "Is our organization culture right for this type of project?"},
                    {"Resources", "Will internal resources be available for this project?"},
                    {"Approach", "Will we build or buy?"},
                    {"Schedule", "How long will this project take?"},
                    {"Schedule", "Is the timeline realistic?"},
                    {"Training/Resources", "Will staff training be required?"},
                    {"Finance/Portfolio", "What is the estimated cost of the project?"},
                    {"Portfolio", "Is this a new initiative or path of an existing initiative?"},
                    {"Portfolio", "How does this project interact with current projects?"},
                    {"Technology", "Is the technology available or new?"}
            };

    public static final String[] checkListResourcesDriver =
            {
                    "None","Uncertainty","Globalization","Innovation","Government Policy & Regulation",
                    "Technology","Diversity","Complexity","Information Overload","Supply Chains",
                    "Strategic Thinking & Problem Solving","Other"
            };

    public static final String[] checkListResourcesSuccessMetrics =
            {
                    "Profitability","Return of Investment",
                    "Delivery of Benefits","Taking advantage of windows of opportunity","Other"
            };
    public static final String[] checkListResourcesSchedule =
            {
                    "1 to 6 months","6 to 12 months","1 to 2 years","2 to 4 years",
                    "4 to 8 years","8 to 16 years","more than 16 years"
            };

    public static final Float[] weightingA =
            {
                    25.0f,25.0f,25.0f,25.0f
            };

    public static final Float[] weightingB =
            {
                    10.0f,10.0f,10.0f,10.0f,
                    10.0f,10.0f,10.0f,10.0f,
                    10.0f,10.0f
            };

    public static final Float[] weightingC =
            {
                    20.0f,10.0f,10.0f,10.0f,
                    10.0f,10.0f,20.0f,10.0f
            };
}
