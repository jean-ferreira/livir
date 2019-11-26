/*
 * Criado por p054341 em 05/07/2006
 *
 */
package br.com.promove.util;

/**
 * @author p054341
 *  
 */
public class AppBaseException extends BaseException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @param novaMessageKey
     */
    public AppBaseException(String novaMessageKey) {
        super(novaMessageKey);
    }

    /**
     * @param novaMessageKey
     * @param messageArgsLoc
     */
    public AppBaseException(String messageKeyLoc, Object[] messageArgsLoc) {
        setMessageKey(messageKeyLoc);
        setMessageArgs(messageArgsLoc);
    }
}