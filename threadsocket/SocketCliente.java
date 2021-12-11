
package threadsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author camil
 */
public class SocketCliente {
    
    public static void main(String[] args){
        
        PrintWriter imprimeNoSocket;
        BufferedReader leitor;
        
        try{
            System.out.println("Cliente tentando se conctar...");//mensagem de entrada
            
            Socket tsocket = new Socket("127.0.0.1",8889);// cria conexao com o socket servidor
            
            System.out.println("Cliente conectado");//cliente conectado
            
            imprimeNoSocket = new PrintWriter(tsocket.getOutputStream());//cria gerenciador de saida do socket
            
            leitor = new BufferedReader(new InputStreamReader(tsocket.getInputStream())); //cria o gerenciador da stream de entrada e leitura
            
            imprimeNoSocket.println("Olá, sou a Camila."); //envia mensagem para o servidor
            
            imprimeNoSocket.flush();//descarrega a stream no socket, dá a vez para o servidor
            
            String textoDoServidor = leitor.readLine(); //recebe os dados do servidor
            
            imprimeNoSocket.println("Esta é a segunda mensagem."); //envia mensagem para o servidor
            
            imprimeNoSocket.flush();//descarrega a stream no socket, dá a vez para o servidor
            
            String textoDoServidor1 = leitor.readLine(); //recebe os dados do servidor
            
            tsocket.close();//fecha o socket
            
            System.out.println("Recebido do Servidor: " + textoDoServidor);
            System.out.println("Recebido do Servidor: " + textoDoServidor1);
            
        }       
        catch(IOException e ){
            System.out.println("Cliente não conseguiu se conctar");
            e.printStackTrace();
        }
    }
}