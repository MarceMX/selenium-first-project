package org.marnnez.pomodel;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO: Complete class documentation
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
     * @since 2022-Aug-29 */
@Slf4j
public class TextboxPage {
    
    /**
     * Class Constructor. No Requirement Reference
     * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
     * @since 2022-Aug-29     */
    public TextboxPage() {
        String logID="#TextboxPage():";
        log.trace("{} Start",logID);
        //checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
        try{
            
            
            //TODO OV: Implement operations of the method
            
    
            log.trace("{} Finish.",logID);
        } catch (Exception e) {
            throw new RuntimeException("Impossible instantiate class TextboxPage due to an internal error.", e);
        }
    }}