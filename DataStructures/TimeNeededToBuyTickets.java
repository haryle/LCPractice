public class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sum = 0;
        for (int i = 0; i < tickets.length; i++){
            if (i < k)
                sum += Math.min(tickets[i], tickets[k]);
            else if (i == k)
                sum += tickets[k];
            else{
                sum += tickets[i]>= tickets[k] ? tickets[k] - 1: tickets[i];
            }
        }
        return sum;
    }

    public static void main(String[] argv){
        TimeNeededToBuyTickets solution = new TimeNeededToBuyTickets();
        System.out.println(solution.timeRequiredToBuy(new int[]{2, 3, 2}, 2));
    }
}
