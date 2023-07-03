    package netflixpropstorage;

    import java.math.BigInteger;
    import java.security.MessageDigest;
    import java.security.NoSuchAlgorithmException;


    public class hashFunction {

        public static String hashFunction(String password)
        {
              try {

                //creates message digest object from library using MD5 encryption
                MessageDigest md = MessageDigest.getInstance("MD5");

                //stores an array of bytes based on the input password 
                byte[] messageDigest = md.digest(password.getBytes());

                //convert byte array into big integer which stores all the digits
                BigInteger no = new BigInteger(1, messageDigest);

                //convert message digest into hex value
                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                return hashtext;
            }

            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    
    public static void main(String args[]) {
        
        
    }
}
