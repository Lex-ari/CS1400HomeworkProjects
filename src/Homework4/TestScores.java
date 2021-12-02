package Homework4;

public class TestScores {

    private int scoreTest1 = 0;
    private int scoreTest2 = 0;
    private int scoreTest3 = 0;

    public TestScores(){
    }

    public TestScores(int scoreTest1, int scoreTest2, int scoreTest3){
        this.scoreTest1 = scoreTest1;
        this.scoreTest2 = scoreTest2;
        this.scoreTest3 = scoreTest3;
    }

    public void setTestScore(int testNum, int score){
        switch(testNum){
            case 1 -> scoreTest1 = score;
            case 2 -> scoreTest2 = score;
            case 3 -> scoreTest3 = score;
            default -> {}//do nothing
        }
    }

    public int getTestScore(int testNum){
        switch(testNum){
            case 1 -> {
                return scoreTest1;
            }
            case 2 -> {
                return scoreTest2;
            }
            case 3 -> {
                return scoreTest3;
            }
            default -> {
                return -1;
            }
        }
    }

    public double getAverage(){
        return (scoreTest1 + scoreTest2 + scoreTest3) / 3.0;
    }

}
