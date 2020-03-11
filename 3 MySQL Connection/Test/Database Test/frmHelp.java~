package beximtex;
/**
 * <p>Title: BeximTex, Help</p>
 * <p>Description: Support Software System</p>
 * <p>Copyright: 2006-2010</p>
 * <p>Company: ASKA</p>
 * @author Adeel Ashraf Malik
 * @version 1.0.0
 */

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.*;
import javax.swing.text.*;
import javax.swing.event.*;

public class frmHelp extends JInternalFrame
{
    public frmHelp()
    {
	super("Help", true, true, true, true);
       	setFrameIcon((Icon)UIManager.get("Tree.openIcon"));
	setBounds( 0, 0, 600, 500);
	HtmlPane html = new HtmlPane();
	setContentPane(html);
    }
}

class HtmlPane extends JScrollPane implements HyperlinkListener
{
    JEditorPane html;
    public HtmlPane()
    {
	try
        {
            URL url = getClass().getResource("/resources/HelpFiles/index.html");
            html = new JEditorPane(url);
	    html.setEditable(false);
	    html.addHyperlinkListener(this);

	    JViewport vp = getViewport();
	    vp.add(html);
	} catch (MalformedURLException e) {System.out.println("Malformed URL: " + e);
	} catch (IOException e) {System.out.println("IOException: " + e);}
    }

    public void hyperlinkUpdate(HyperlinkEvent e)
    {
	if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
        {
	    linkActivated(e.getURL());
	}
    }

    protected void linkActivated(URL u)
    {
	Cursor c = html.getCursor();
	Cursor waitCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
	html.setCursor(waitCursor);
	SwingUtilities.invokeLater(new PageLoader(u, c));
    }

    class PageLoader implements Runnable
    {
	PageLoader(URL u, Cursor c)
        {
	    url = u;
	    cursor = c;
	}

        public void run()
        {
	    if (url == null)
            {
		html.setCursor(cursor);
		Container parent = html.getParent();
		parent.repaint();
	    }
            else
            {
		Document doc = html.getDocument();
		try
                {
		    html.setPage(url);
		}
                catch (IOException ioe)
                {
                    html.setDocument(doc);
		    getToolkit().beep();
		}
                finally
                {
		    url = null;
		    SwingUtilities.invokeLater(this);
		}
	    }
	}
	URL url;
	Cursor cursor;
    }
}