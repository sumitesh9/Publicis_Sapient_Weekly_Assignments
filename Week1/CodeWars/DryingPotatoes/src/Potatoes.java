class Potatoes {
    
    public static int potatoes(int p0, int w0, int p1) {
        // your code
        int final_weight = (w0 * (100 - p0)) / (100 - p1);
        return final_weight;
    }
}