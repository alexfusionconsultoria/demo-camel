package br.com.fusionconsultoria.gs.democamel;

import org.springframework.stereotype.Service;

@Service("nameService")
public class NameServiceImpl implements NameService {

    private static final Name THE_NAME = new Name("Jacopo");

    public Name getName() {
        return THE_NAME;
    }

}
