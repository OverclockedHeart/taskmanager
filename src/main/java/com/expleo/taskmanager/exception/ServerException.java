package com.expleo.taskmanager.exception;

public class ServerException extends RuntimeException{

    public ServerException(){
        super("Errore interno del server, cantatta l'amministratore del server");

    }
}
