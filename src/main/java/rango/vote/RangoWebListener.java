package rango.vote;

import javax.servlet.annotation.WebListener;
import org.springframework.web.context.ContextLoaderListener;

/**
 * RangoListener
 * loads spring context without the need of an web.xml 
 */
@WebListener
public class RangoWebListener extends ContextLoaderListener{

}
