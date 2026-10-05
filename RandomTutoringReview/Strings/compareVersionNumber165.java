package Strings;

public class compareVersionNumber165 {

    public static void main(String[] args) {

        //System.out.println(compareVersion("1.2", "1.10"));
        //System.out.println(compareVersion("0.1", "1.1"));
        //System.out.println(compareVersion("3.4.5", "3.4.5"));
        System.out.println(compareVersion("2.3", "2.3.0"));
        System.out.println(compareVersion("1.01", "1.001"));
    }

    public static int compareVersion(String version1, String version2) {

        if(version1.length() == 0 && version2.length() == 0){

            return 0;
        }

        int rev1 = processRevision(version1);
        int rev2 = processRevision(version2);

        if(rev1 < rev2) return -1;
        if(rev1 > rev2) return 1;
        
        version1 = remainingString(version1);
        version2 = remainingString(version2);

        return compareVersion(version1, version2);
    }

    public static int processRevision(String version){

        int runningSum = 0;

        for(int i = 0; i < version.length(); i++){

            char digit = version.charAt(i);

            if(digit == '.'){

                return runningSum;
            }

            int digitValue = digit - '0';

            runningSum *= 10;
            runningSum += digitValue;
        }

        return runningSum;
    }

    public static String remainingString(String version){

        int index = version.indexOf('.');

        if(index == -1){

            return "";
        }

        return version.substring(index+1);
    }
}
