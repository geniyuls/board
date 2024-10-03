//import java.util.ArrayList;
//import java.util.List;
//
//public class Board2 {
//    public static void main(String[] args) {
//        String queryString = "a=10&b=20&c=30%d=40";
//        String[] queryStringBits = queryString.split("&");
//
//        List<String> paramNames = new ArrayList<>();
//        List<String> paramValues = new ArrayList<>();
//
//        for (String bit : queryStringBits) {
//            String[] bitsBits = bit.split("=");
//            String paramName = bitsBits[0];
//            String paramValue = bitsBits[1];
//
//            paramNames.add(paramName);
//            paramValues.add(Integer.parseInt(paramValue));
//        }
//
//        for(int i = 0; i < paramNames.size(); i++){
//            String paramName = paramNames.get(i);
//            int paramValue = paramValues.get(i);
//        }
//    }
//}