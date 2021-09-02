package ua.com.alevel.cmd;

public class AppMessages{

    public static final String HORIZONTAL_BORDER = " ==========================================================\n";
    public static final String WELCOMING = "|----------------------Hello, user!------------------------|\n";
    public static final String MAIN_DESCRIPTION = "|-----------------Enter \'s\' to start!---------------------|\n";
    public static final String STOP_PROGRAM = "|---------------Or enter \'q\' to exit!---------------------|\n";

    public static final String CHOOSE_TO_EXIT_BY_0 = "if you want to exit, please, enter 0\n";
    public static final String CHOOSE_TO_CONTINUE_OR_EXIT = "Please, input '1' to continue, '0' to stop\n";
    public static final String CHOOSE_TO_EXIT_BY_Q = "q";

    public static final String INSTRUCTION_TO_INPUT_ARRAY = "Please, input your array of numbers like that '1,2,3,4'\n";
    public static final String INSTRUCTION_TO_INPUT_CAPACITY = "Please, input your capacity:\n";
    public static final String CREATE_FIRST_MATHSET = "Create your first mathSet..\n";
    public static final String CREATE_SECOND_MATHSET = "Create your second mathSet..\n";
    public static final String CREATE_THIRD_MATHSET = "Create your third mathSet..\n";
    public static final String CREATE_MATHSET_TO_INTERSECT = "Create your mathSet to intersect with..\n";


    public static final String ADD_TO_MATHSET = "* To add, join or intersect, please, enter \t 1\n";
    public static final String SORT_MATHSET = "* To sort mathset, please, enter \t 2\n";
    public static final String GET_FROM_MATHSET = "* To find smth in mathset, please, enter \t 3\n";
    public static final String MATHSET_TO_ARRAY = "* To convert mathset in array, please, enter \t 4\n";
    public static final String MATHSET_CLEAR = "* To cut or clear mathset, please, enter \t 5\n";

    public static final String CLEAR_ALL_MATHSET = "* To clear all mathset, please, enter \t 1\n";
    public static final String CLEAR_PART_OF_MATHSET = "* To clear part of mathset, please, enter \t 2\n";
    public static final String CUT_PART_OF_MATHSET = "* To cut part of mathset, please, enter \t 3\n";

    public static final String GET_ARRAY_FROM_ALL_MATHSET = "* To get array of full mathset, please, enter \t 1\n";
    public static final String GET_ARRAY_FROM_PART_MATHSET = "* To get array of some part of mathset, please, enter \t 2\n";

    public static final String GET_SMTH_FROM_MATHSET = "* To get smth from mathset, please, enter \t 1\n";
    public static final String GET_MAX_FROM_MATHSET = "* To get smth from mathset, please, enter \t 2\n";
    public static final String GET_MIN_FROM_MATHSET = "* To get smth from mathset, please, enter \t 3\n";
    public static final String GET_AVERAGE_FROM_MATHSET = "* To get smth from mathset, please, enter \t 4\n";
    public static final String GET_MEDIAN_FROM_MATHSET = "* To get smth from mathset, please, enter \t 5\n";

    public static final String SORT_ALL_MATHSET_BY_DESC = "* To sort mathset by desc, please, enter \t 1\n";
    public static final String SORT_PART_BY_DESC = "* To sort part of mathset by desc, please, enter \t 2\n";
    public static final String SORT_MATHSET_BY_DESC_FROM_VALUE = "* To sort mathset by desc from value, please, enter \t 3\n";
    public static final String SORT_ALL_MATHSET_BY_ASC = "* To sort mathset by asc, please, enter \t 4\n";
    public static final String SORT_PART_BY_ASC = "* To sort mathset by asc, please, enter \t 5\n";
    public static final String SORT_MATHSET_BY_ASC_FROM_VALUE = "* To sort mathset by asc from value, please, enter \t 6\n";
    public
    static final String ADD_NUMBER = "* To add some number to mathset, please, enter \t 1\n";
    static final String ADD_NUMBERS = "* To add numbers to mathset, please, enter \t 2\n";
    static final String JOIN_MATHSET = "* To join mathset to mathset, please, enter \t 3\n";
    static final String JOIN_MATHSETS = "* To join mathsets to mathset, please, enter \t 4\n";
    static final String INTERSECTION_MATHSET = "* To intersect mathset with mathset, please, enter \t 5\n";
    static final String INTERSECTION_MATHSETS = "* To intersect mathset with mathset, please, enter \t 6\n";

    static final String CREATING = "Choose, how you want to create this mathSet:\n";
    static final String CREATE_EMPTY = "* 1 \t - if you want an empty\n";
    static final String CREATE_EMPTY_CAPACITY = "* 2 \t - if you want an empty with your capacity\n";
    static final String CREATE_WITH_ARRAY = "* 3 \t - if you want mathSet with array in it\n";
    static final String CREATE_WITH_ARRAYS = "* 4 \t - if you want mathSet with arrays in it\n";
    static final String CREATE_WITH_MATHSET = "* 5 \t - if you want mathSet with mathSet in it\n";
    static final String CREATE_WITH_MATHSETS = "* 6 \t - if you want mathSet with mathSets in it\n";

    public static final String SPACE = " ";
    public static final String NO_SPACE = " ";

    public static final String WARN_INCORRECT_INPUT = "|------------Incorrect input. Try Again..------------------|\n";
    public static final String EMPTY_SET_EXCEPTION = "This mathset is empty!";
    public static final String NULL_MATHSET_EXCEPTION = "This mathset is null!";

    public static final String REGEX_FOR_INPUT_NUMBER = "^\\d{1,5}$";
    public static final String REGEX_FOR_INPUT_CAPACITY = "\\d{1,3}";
    public static final String REGEX_FOR_ONE_EL_ARRAY = "^\\d{1,5}$";
    public static final String REGEX_FOR_ARRAY = "^(\\d{1,3},)+(\\d{1,3})$";
}