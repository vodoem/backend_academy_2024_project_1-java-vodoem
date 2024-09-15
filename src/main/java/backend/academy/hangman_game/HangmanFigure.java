package backend.academy.hangman_game;

public class HangmanFigure {
    private final String[] stages = {
        """

         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /
         | | /
         | |/
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\""\"""\"""\"|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,

        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /
         | |/
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |          ||  `/,|
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |          ||  `/,|
         | |          (\\\\`_.'
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |          ||  `/,|
         | |          (\\\\`_.'
         | |         .-`--'.
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |          ||  `/,|
         | |          (\\\\`_.'
         | |         .-`--'.
         | |        /Y . . Y\\
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |          ||  `/,|
         | |          (\\\\`_.'
         | |         .-`--'.
         | |        /Y . . Y\\
         | |       // |   | \\\\
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |          ||  `/,|
         | |          (\\\\`_.'
         | |         .-`--'.
         | |        /Y . . Y\\
         | |       // |   | \\\\
         | |
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |          ||  `/,|
         | |          (\\\\`_.'
         | |         .-`--'.
         | |        /Y . . Y\\
         | |       // |   | \\\\
         | |      //  | . |  \\\\
         | |
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |          ||  `/,|
         | |          (\\\\`_.'
         | |         .-`--'.
         | |        /Y . . Y\\
         | |       // |   | \\\\
         | |      //  | . |  \\\\
         | |     ')   |   |   (`
         | |
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |          ||  `/,|
         | |          (\\\\`_.'
         | |         .-`--'.
         | |        /Y . . Y\\
         | |       // |   | \\\\
         | |      //  | . |  \\\\
         | |     ')   |   |   (`
         | |          ||'||
         | |
         | |
         | |
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
         ___________.._______
         | .__________))______|
         | | / /      ||
         | |/ /       ||
         | | /        ||.-''.
         | |/         |/  _  \\
         | |          ||  `/,|
         | |          (\\\\`_.'
         | |         .-`--'.
         | |        /Y . . Y\\
         | |       // |   | \\\\
         | |      //  | . |  \\\\
         | |     ')   |   |   (`
         | |          ||'||
         | |          || ||
         | |          || ||
         | |          || ||
         | |
         |""\"""\"""\"""\"""\"""\"""\"""|
         |"|"|"|"|"|"|"|"|"|"|"|"|

        """,
        """
        ___________.._______
        | .__________))______|
        | | / /      ||
        | |/ /       ||
        | | /        ||.-''.
        | |/         |/  _  \\
        | |          ||  `/,|
        | |          (\\\\`_.'
        | |         .-`--'.
        | |        /Y . . Y\\
        | |       // |   | \\\\
        | |      //  | . |  \\\\
        | |     ')   |   |   (`
        | |          ||'||
        | |          || ||
        | |          || ||
        | |          || ||
        | |         / | | \\
        |""\"""\"""\"| `-' `-' |""\"|
        |"|"|"|"|"|"|"|"|"|"|"|"|

        """};

    private final int maxAttempts;

    public HangmanFigure(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public String getFigure(int remainingAttempts) {
        int totalStages = stages.length;
        int stageIndex =
            (totalStages - 1) - (int) Math.floor(((double) remainingAttempts / maxAttempts) * (totalStages - 1));

        return stages[limitStageIndex(stageIndex)];
    }

    private int limitStageIndex(int stageIndex) {
        int totalStages = stages.length;
        if (stageIndex >= totalStages) {
            return totalStages - 1;
        } else if (stageIndex < 0) {
            return 0;
        }
        return stageIndex;
    }

}

