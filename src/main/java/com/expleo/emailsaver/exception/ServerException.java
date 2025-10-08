package com.expleo.emailsaver.exception;

public class ServerException extends RuntimeException{

    public ServerException(){
        super("Errore interno del server, cantatta l'amministratore del server");

    }
}
