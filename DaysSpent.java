public class DaysSpent {
    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] aliceArrive = arriveAlice.split("-");
        String[] aliceLeave = leaveAlice.split("-");
        String[] bobArrive = arriveBob.split("-");
        String[] bobLeave = leaveBob.split("-");

        int[] arriveA = {Integer.parseInt(aliceArrive[0]), Integer.parseInt(aliceArrive[1])};
        int[] leaveA = {Integer.parseInt(aliceLeave[0]), Integer.parseInt(aliceLeave[1])};
        int[] arriveB = {Integer.parseInt(bobArrive[0]), Integer.parseInt(bobArrive[1])};
        int[] leaveB = {Integer.parseInt(bobLeave[0]), Integer.parseInt(bobLeave[1])};

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] start = new int[2];
        if(arriveA[0] > arriveB[0]){
            start[0] = arriveA[0];
            start[1] = arriveA[1];
        }else if(arriveA[0] < arriveB[0]){
            start[0] = arriveB[0];
            start[1] = arriveB[1];
        }else{
            start[0] = arriveA[0];
            if(arriveA[1] > arriveB[1]){
                start[1] = arriveA[1];
            }else{
                start[1] = arriveB[1];
            }
        }

        int[] end = new int[2];

        if(leaveA[0] > leaveB[0]){
            end[0] = leaveB[0];
            end[1] = leaveB[1];
        }else if(leaveA[0] < leaveB[0]){
            end[0] = leaveA[0];
            end[1] = leaveA[1];
        }else{
            end[0] = leaveA[0];
            if(leaveA[1] > leaveB[1]){
                end[1] = leaveB[1];
            }else{
                end[1] = leaveA[1];
            }
        }
        if (start[0] > end[0]){
            return 0;
        }
        if (start[0]==end[0] && start[1]>end[1]){
            return 0;
        }

        if(start[0] == end[0]){
            return end[1]-start[1]+1;
        }else{
            int out = days[start[0]-1] - start[1];
            start[0]++;
            while(start[0] < end[0]){
                out += days[start[0]-1];
                start[0]++;
            }
            return out + end[1] + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(countDaysTogether("10-01","10-31","11-01","12-31"));
    }
}
