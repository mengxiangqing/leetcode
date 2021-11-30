
class Solutio {

    public int remainOfpeach(int n) {
        int num = n;
        if (n == 1) {
            return 1;
        } else {
            num = remainOfpeach(n) / 2 - 1;
        }
        return num;
    }
    
}