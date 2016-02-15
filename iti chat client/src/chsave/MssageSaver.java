package chsave;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import messagesave.Msgc;
import messagesave.ObjectFactory;
import messagesave.Sessionc;

public class MssageSaver {

    JAXBContext context;
    List<Msgc> msglist = new ArrayList<>();

    public MssageSaver() {
        try {
            /**
             * get new instance of package that contain classes of XMl which
             * created by JAXB
             */
            context = JAXBContext.newInstance("messagesave");
            Unmarshaller unmarsh = context.createUnmarshaller();
            JAXBElement JAXBMsg = (JAXBElement) unmarsh.unmarshal(new File("src/chsave/Message.xml"));
            Sessionc session = (Sessionc) JAXBMsg.getValue();
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void saveXML(String msgline, String path, int size, String color, String face) {
        try {
            ObjectFactory factory = new ObjectFactory();
            Sessionc session = factory.createSessionc();
            Msgc newmsg = new Msgc();
            newmsg.setBody(msgline);
            newmsg.setSize(size);
            newmsg.setFace(face);
            newmsg.setColor(color);

            /**
             * here instantiate object of ArrayList to add msg to it
             */
            msglist.add(newmsg);

            session.getMsg().addAll(msglist);
            //*****************************************************
            JAXBElement newSession = factory.createSession(session);
            Marshaller marsh = context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marsh.marshal(newSession, new FileOutputStream(path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MssageSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(MssageSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
