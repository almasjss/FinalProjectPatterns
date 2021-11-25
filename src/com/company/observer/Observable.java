package com.company.observer;

public interface Observable {
    void addSubject(String subject);
    void removeSubject(String subject);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
