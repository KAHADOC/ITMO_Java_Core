package edu.java.itmo_course.hw10.task.images;

import java.io.*;

public final class Editor implements Cloneable, Serializable {
    private Drawable drawable;

    public Editor(Drawable drawable) { // конструктор
        setDrawable(drawable);
    }

    public void setDrawable(final Drawable drawable){
        this.drawable = drawable;
    }

    public void show(){
        drawable.draw();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Editor clonedCopy = (Editor) super.clone();
        clonedCopy.drawable = this.drawable;  // Тут я запутался.
        // drawable - похоже что это instance of an Anonymous class? Как это клонировать?
        return clonedCopy;
    }

    public Editor deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteStreamOut = new ByteArrayOutputStream();
        ObjectOutputStream objectOut = new ObjectOutputStream(byteStreamOut);
        objectOut.writeObject(this);

        ByteArrayInputStream byteStreamIn =
                new ByteArrayInputStream(byteStreamOut.toByteArray());
        ObjectInputStream objectIn = new ObjectInputStream(byteStreamIn);
        return (Editor) objectIn.readObject();
    }
}
