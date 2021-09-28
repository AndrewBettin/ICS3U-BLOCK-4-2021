package week4;

public class BayvewlgenPool {
    public static void main(String[] args){
        final int length = 20;
        final int width = 8;
        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 3;
        final int deepHeight = 8;
        double pyth = Math.sqrt(Math.pow(transition, 2) - Math.pow(deepHeight - shallowHeight, 2));
        double deepLength =  length - shallowLength - pyth;
        
        final int linerCost = 2;

        double volume = getVolume(length, width, shallowLength, shallowHeight, transition, deepHeight);
        double surfaceArea = getSurfaceArea(pyth, length,width, shallowLength,
        shallowHeight, transition, deepHeight, deepLength);

        System.out.println(volume);
        System.out.println(surfaceArea);

    }
// sa of a rectangular prism is : 2(l*w) + 2(h*w) + l*h
// sa of a triangular pism is: b*h(t) + b * t(b^2+h^2)
    private static double getSurfaceArea(double pyth, int length, int width, int shallowLength,
    int shallowHeight, int transition, int deepHeight, double deepLength) {
        double triSA = width*pyth + width * transition;
        double shallowSA = 2*(shallowLength*width) + (shallowHeight*width) + shallowLength * shallowHeight;
        double deepSA = 2*(deepLength*width) + (deepHeight*width) + deepLength * deepHeight;
        return triSA + shallowSA + deepSA;
    }
    

    private static double getVolume(int length, int width, int shallowLength,
        int shallowHeight, int transition, int deepHeight) {
        double pyth = Math.sqrt(Math.pow(transition, 2) - Math.pow(deepHeight - shallowHeight, 2));
        double deepLength =  length - shallowLength - pyth;
        //double volume = length - shallowLength - pyth; 
        double shallowVolume = shallowLength * shallowHeight * width;
        double transitionVolume = (((deepHeight - shallowHeight) * pyth / 2) * width);
        double transitionVrect = (pyth * (shallowHeight)*width);
        double deepVolume = deepHeight * deepLength * width;
        return shallowVolume + transitionVolume + transitionVrect + deepVolume;
    }

    
}
