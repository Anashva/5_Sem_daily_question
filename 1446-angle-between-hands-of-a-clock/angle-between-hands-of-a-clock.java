class Solution {
    public double angleClock(int hour, int minutes) {
        double m=minutes*6.0;
        double h=hour*30+minutes*0.5;
        double angle=Math.abs(h-m);
        return Math.min(angle,360-angle);
    }
}