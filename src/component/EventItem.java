package component;

import java.awt.Component;
import java.awt.event.MouseEvent;
import entity.PlayList;
import entity.Song;

/**
 *
 * @author NGUYEN VAN SI
 */
public interface EventItem {

    public void clickEvent(Component com, Song song);
    
    public void clickEvent(Component com, PlayList playList);
    
    public void EnterEvent(Component com, Song song);
    
    public void ExitEvent(Component com, Song song, MouseEvent e);

    
}
