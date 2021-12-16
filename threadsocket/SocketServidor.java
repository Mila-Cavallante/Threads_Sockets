/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {
    
    public static void main(String[] args) throws ClassNotFoundException {
        Socket tsocket;
        PrintWriter imprimeNoSocket;
        BufferedReader leitor;
        ServerSocket ss;
        
        try{
            System.out.println("Servidor em espera...");//Mensadgem de espera
            
            ss=new ServerSocket(8889); //instancia e espera uma conexão
            
            tsocket = ss.accept(); //ao estabelecer conexao, aceita
            
            imprimeNoSocket = new PrintWriter(tsocket.getOutputStream()); //estabelece um gerenciamento de stream de saída
            
            InputStream tis = tsocket.getInputStream();//estabele um gerenciamento de stream de entrada
            
            InputStreamReader tisr= new InputStreamReader(tis); //estabele um gerenciamento de stream de leitura
            
            leitor = new BufferedReader(tisr); // faz a leitura da stream de leitura para leitor
          
            String textoDoCliente = leitor.readLine(); //obtem o texto da stream de leitura
            
            imprimeNoSocket.println("Olá, sou o servidor.");//imprimi o texto para a stream
            
            imprimeNoSocket.flush();//descarrega a stream para o socket, dá a vez para o cliente
            
            //String textoDoCliente1 = leitor.readLine();
            
            //imprimeNoSocket.println("Mensagem recebida.");//imprimi o texto para a stream
            
           // imprimeNoSocket.flush();//descarrega a stream para o socket, dá a vez para o cliente
            
            tsocket.close(); //fecha o socket
            
            System.out.println("Recebido do Cliente: " + textoDoCliente);
                   
            //System.out.println("Recebido do Cliente: " + textoDoCliente);
            //System.out.println("Recebido do Cliente: " + textoDoCliente1);
        }
        catch(IOException e ){
            System.out.println("Cliente não conseguiu se conctar");
            e.printStackTrace();            
        }
    }
    
}
