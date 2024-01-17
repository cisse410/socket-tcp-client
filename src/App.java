import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Connexion Reseau TCP");
        // adresse IP du serveur ou le nom
        InetAddress addr = InetAddress.getByName("10.157.59.129");
        // Ouverture de la connexion avec le serveur sur le port 9000
        Socket socket = new Socket(addr, 7777);
        // Construction du flux d'objet depuis le flux Socket
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        // Ecriture d'une chaine dans le flux de sortie : c'est a dire envoi de donnees au serveur

        objectOutputStream.writeObject(new String("Je suis la"));

        // attente de reception de donnees venant du serveur (avec la methode readObject())
        // on sait qu'on attend une chaine, on peut donc faire un cast directement

        String chaine = (String)objectInputStream.readObject();
        System.out.println("Recu du serveu : " + chaine);

        socket.close();
    }
}
