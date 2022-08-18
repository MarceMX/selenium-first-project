package org.marnunez;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO: Complete class documentation
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
     * @since 2022-Aug-17 */
@Slf4j
public class ExeUtilities {
    
    /**
     * Class Constructor. No Requirement Reference
     * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
     * @since 2022-Aug-17     */
    public ExeUtilities() {
        String logID="#ExeUtilities():";
        log.trace("{} Start",logID);
        //checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
        try{
            
            
            //TODO OV: Implement operations of the method
            
    
            log.trace("{} Finish.",logID);
        } catch (Exception e) {
            throw new RuntimeException("Impossible instantiate class ExeUtilities due to an internal error.", e);
        }
    }}