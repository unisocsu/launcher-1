private final DesktopSerializer serializer =
        new DesktopSerializer();

public void save() {

    String json =
            serializer.serialize(desktopItems);

    settings.desktop.setLayout(json);

}

public void load() {

    desktopItems.clear();

    desktopItems.addAll(

            serializer.deserialize(

                    settings.desktop.getLayout()

            )

    );

}
