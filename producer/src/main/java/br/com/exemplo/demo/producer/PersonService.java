package br.com.exemplo.demo.producer;

import br.com.exemplo.demo.domain.Person;

public interface PersonService {

    void sendPersonMessage(final Person person);

}
