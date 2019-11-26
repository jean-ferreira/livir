 
package br.com.promove.util;

 
public class BaseException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Throwable causaRaiz = null;

    private String messageKey = null;

    private Object[] messageArgs = null;

    public BaseException() {
        super();
    }

    public BaseException(String messageKeyLoc, Throwable causa,
            Object[] messageArgsLoc) {
        setMessageKey(messageKeyLoc);
        setCausaRaiz(causa);
        setMessageArgs(messageArgsLoc);
    }

    public BaseException(Throwable causa) {
        this.causaRaiz = causa;
    }

    public BaseException(String novaMessageKey) {
        this.messageKey = novaMessageKey;
    }

    public void setMessageKey(String key) {
        this.messageKey = key;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageArgs(Object[] args) {
        this.messageArgs = args;
    }

    public Object[] getMessageArgs() {
        return messageArgs;
    }

    public void setCausaRaiz(Throwable anException) {
        causaRaiz = anException;
    }

    public Throwable getCausaRaiz() {
        return causaRaiz;
    }

}
