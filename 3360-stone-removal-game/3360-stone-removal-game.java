
class Solution {
    public boolean canAliceWin(int n) {

        int move = 10;
        int count = 0;

        while (n >= move) {
            n = n - move;
            move--;
            count++;
        }

        return count % 2 == 1;
    }
}
