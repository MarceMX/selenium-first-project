package org.marnunez;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO: Complete class documentation
 * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
     * @since 2022-Aug-19 */
@Slf4j
public class ReadPropertiesFile {
    
    /**
     * Class Constructor. No Requirement Reference
     * @author <a href='mailto:marcela.nunez@gmail.com'>Marcela Nunez</a>
     * @since 2022-Aug-19     */
    public ReadPropertiesFile() {
        String logID="#ReadPropertiesFile():";
        log.trace("{} Start",logID);
        //checkNotNull("Impossible to create the object. The parameter can't be null.",parameter);
        try{
            
            
            //TODO OV: Implement operations of the method
            
    
            log.trace("{} Finish.",logID);
        } catch (Exception e) {
            throw new RuntimeException("Impossible instantiate class ReadPropertiesFile due to an internal error.", e);
        }
    }}