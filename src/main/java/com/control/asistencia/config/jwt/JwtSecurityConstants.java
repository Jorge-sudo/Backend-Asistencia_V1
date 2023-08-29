package com.control.asistencia.config.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

public class JwtSecurityConstants {
    public static final long JWT_EXPIRATION_TOKEN = 3600000; //equivaler a 5 min, donde 60000 = a 1 min
    public static final Key JWT_FIRMA = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public static final String HEADER_AUTHORIZATION_KEY = "Authorization"; // Nombre del encabezado HTTP que se utiliza para enviar el token de autenticación
    public static final String RSA_PRIVATE = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIG/AIBADANBgkqhkiG9w0BAQEFAASCBuYwggbiAgEAAoIBgQCfHGMSZvIkG07Y\n" +
            "v2/WqXRi0HLgHxrkgTXVUJCcFV3Shhfi/cstNhCOK63WjAEUKfFpcWVkMKtTUECq\n" +
            "C3FcxUBcjJPHr3iYj/LyNRvIhrZWUUMct88/X/s2AqrLcEaRiSj/cNLmnqqF871Y\n" +
            "K2VFzw5wifnTR76SsTQkKnfsENzKm1JVtMXv3CkIjK6fmVQJux4OBhv6e2K8T3yZ\n" +
            "lEV+bZziytsZMlTFizzm0KxrXtQaytVisjx95qytnk0+4IJQFhiiCwNAxoa4PnUq\n" +
            "y6pc00IgjqRAsWGRdft+Da/vyh9FIWzEmakHOrgaVNlZChooz+rA9iozyWulleMO\n" +
            "H419Vkzclej7/fDvm7iYEZfqiQB7YIXyBV9ZNLswvtM7NPYujFj3DJX6E0yp8gnV\n" +
            "mLzyNC9m6MjfPEAQxececxA3le6MONRJoD0Eg+rxnkFH5pbykLmehVrZKn7slwXJ\n" +
            "XWl+F9FkTyYKqBb88oBKNJZtKNkMduwGJEkGwPL1OMGq3KicGlECAwEAAQKCAYAK\n" +
            "BmaanfhjPII9B2DTUGV4JWSbiPIvlBGRgWw/HVyGO3MtVurSjC3CW2+uTS9zNwpS\n" +
            "J7Yo+CUPUIbmf+aSXw5FVokoI37wc99tkdmQiqZZ7XBSUqWA+3nvRv8+ZrJXkKIP\n" +
            "6Cqto7EgVAFp2QAeRCPHhPYD8SkJgpdDsRZRviU/McagBk4TZRaDxqNpBGbmXw8P\n" +
            "eKSSJWyM62AxKAWx59Oi+X+RCJoNQU7ixyKZ+EVac826lHrZvutB3C/HRquHQsEM\n" +
            "oeWVIBY3uTv/Dk8IpQpv+AsN64/bwDG8I9jkjERaN1UwQnOp7h5iQh536WHycy8A\n" +
            "iaaViE/+Ln1aYFBNwInX/qEdyIbO3AyvEgReC8I/sp7DJ/EbZDkGuH8vW7vTWl5e\n" +
            "MAsIep4u8reRNUzFQ50rpJ1WaOZDAPiEAhbWbxZEYzcLUXauiCuVIV05IxOhTtpw\n" +
            "8+K1lHQ533gngODOsGJQTv/uMqusZFjD7OY7irgyb1ycY0vBu53DtIWI/mib+xEC\n" +
            "gcEAzu9HYXil2MkUUsX4J+9ZexSoyA0+Fy/zEoNPOScO+1rq9ubFC7LRFEx8iAI1\n" +
            "4Z9ddptpu7nFMPbfhyFioMSflGrArJl0+cRoLgh1ZwFbM41Sq+gX+gymOVNzZdlA\n" +
            "A4ISwj2i9E0G5tIuAe/TGrNln9xYBM2sNdZmYuk8Sp0QBZmY3QfZtFVgycmTQSiI\n" +
            "xTcw7KgoViex2n5+SN6euTADCYU0WGWem/ukQB7UzzbttATJMMF9oeudqWSU4WBY\n" +
            "HmG5AoHBAMTWQNKpcRrC6DYRYH9vzJ+OmENk7l+gkINfiTgjYzW5NvPFhnu4/ABo\n" +
            "AmxjbFMlnMqZy4IwQkjiL2IAX2ZV5/Wy+EyQE+fmkAfp1JCCpvERlkP6c4oJsW8q\n" +
            "KN3nQTymkd6rYWgHq0MjbCzhoFNBdmwowlDA5gmymvlXtomsbiiLBoIHt/Rbumq6\n" +
            "gsCm6f5jZDjDoQ3XrcnffZmCSoZWw7nLfqYt9RDZB4NjCnt2WFN/el95UkQXaAfB\n" +
            "EKezbFGpWQKBwBxntACpMvrC/0staZbxv/KpL1Hmn3NHXbJY2/MYbXILVN13Z+zn\n" +
            "KtQCe8WfqA3EdmvlgWoHYg4KlTxTVNqEovMYhEIs/mWalEJdXuA4y3AUIhj+zuu/\n" +
            "+ME9t0VvwN26aSDInSmzuRLOHwqdBPlRTs3WzS47nTv2pi9FnMURMjXSk60jerrK\n" +
            "TXLlfJUhH0UTAmA55O+Om1dGrccK5/a7pG8WHc1UhaUbsbwrf0LCY3amgYdzx+8G\n" +
            "DKpH6DfXpcDl4QKBwG1A3soO8pCADpO0IXOagmEtrKX7p7O8U3oX1Por6i0vmKjF\n" +
            "wld53aX8FRxEMyQThGuP4b1pO+FoahRjUJBkrlNZ+yfD8MiO2PMLfsiXPEIiGN2y\n" +
            "bd74clvZcsV4TmVzrxOA3Jf5ab3iM3DV6z9K3og6N2DLMOPBFvO/E7pm0t3+DKav\n" +
            "0hL3twj2bQyxmL9yO3amXwZn6DZcrkI+Z08ZaZn+sVVbvOKVE+6BUpgkn/H4l9vW\n" +
            "YysYMs3bA3uRw1WwQQKBwAssySeHXodPpqmPAFaz3QdF8LXDmom7SebSVf7dKf6j\n" +
            "FaYC4zyxg6inZdTj8kJd2wMb/yJz620cwRbm2Og7WgDmgo+F7illqOl7sisWCcJE\n" +
            "zHA+mOt/Z75hf0cDxvKQLe14xlcrfoXrOnkrPAiN3Gtip6iupIWMs6oBItMmcH2I\n" +
            "M/6bXbTR5J0ppBI0qWswB95O3Fc8maLBzoRiUVctChloP9/emMv50K/y2jf3bzwU\n" +
            "LgKBSODWGCAcmGOtk2nE1w==\n" +
            "-----END PRIVATE KEY-----";

    public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAnxxjEmbyJBtO2L9v1ql0\n" +
            "YtBy4B8a5IE11VCQnBVd0oYX4v3LLTYQjiut1owBFCnxaXFlZDCrU1BAqgtxXMVA\n" +
            "XIyTx694mI/y8jUbyIa2VlFDHLfPP1/7NgKqy3BGkYko/3DS5p6qhfO9WCtlRc8O\n" +
            "cIn500e+krE0JCp37BDcyptSVbTF79wpCIyun5lUCbseDgYb+ntivE98mZRFfm2c\n" +
            "4srbGTJUxYs85tCsa17UGsrVYrI8feasrZ5NPuCCUBYYogsDQMaGuD51KsuqXNNC\n" +
            "II6kQLFhkXX7fg2v78ofRSFsxJmpBzq4GlTZWQoaKM/qwPYqM8lrpZXjDh+NfVZM\n" +
            "3JXo+/3w75u4mBGX6okAe2CF8gVfWTS7ML7TOzT2LoxY9wyV+hNMqfIJ1Zi88jQv\n" +
            "ZujI3zxAEMXnHnMQN5XujDjUSaA9BIPq8Z5BR+aW8pC5noVa2Sp+7JcFyV1pfhfR\n" +
            "ZE8mCqgW/PKASjSWbSjZDHbsBiRJBsDy9TjBqtyonBpRAgMBAAE=\n" +
            "-----END PUBLIC KEY-----" ;
}
