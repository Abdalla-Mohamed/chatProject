package message.services;

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
import message.Msgc;
import message.ObjectFactory;
import message.MassageType;
import org.w3c.dom.Attr;

public class MessageOperation {

    JAXBContext context;
    List<Msgc> msglist = new ArrayList<>();

    public MessageOperation() {

        try {
            context = JAXBContext.newInstance("message");
            Unmarshaller unmarsh = context.createUnmarshaller();
            JAXBElement JAXBMsg = (JAXBElement) unmarsh.unmarshal(new File("src/message/Message.xml"));

            MassageType massageType = (MassageType) JAXBMsg.getValue();
            Msgc mContent=new Msgc();
            
            msglist.add(mContent);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void saveXML(String msgBody, String path, int size, String color, String from,String to,String date,String font) {
        try {
            ObjectFactory factory = new ObjectFactory();
            MassageType msgtype = factory.createMassageType();
            Msgc newmsg = new Msgc();
            newmsg.setBody(msgBody);
            newmsg.setColor(color);
            newmsg.setDate(date);
            newmsg.setFont(font);
            newmsg.setFrom(from);
            newmsg.setSize(size);
            //newmsg.setTo(to);


            msglist.add(newmsg);
            msgtype.getMsg().addAll(msglist);
            //*****************************************************
            JAXBElement newSession = factory.createMassage(msgtype);
            Marshaller marsh = context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marsh.marshal(newSession, new FileOutputStream(path));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MessageOperation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(MessageOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
