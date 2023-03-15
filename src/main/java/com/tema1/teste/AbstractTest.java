package com.tema1.teste;

import com.tema1.service.LinkAllService;

/**
 * Class which should be extended by all tests, instantiated a LinkAllService object
 * to be used in said tests
 */
public abstract class AbstractTest implements ITest{

    protected LinkAllService linkAllService = new LinkAllService();
}
