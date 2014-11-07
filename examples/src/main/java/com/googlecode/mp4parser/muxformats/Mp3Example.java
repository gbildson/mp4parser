package com.googlecode.mp4parser.muxformats;

import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.io.*;

/**
 * Created with vi.
 */
public class Mp3Example {
    public static void main(String[] args) throws IOException {
        MP3TrackImpl myTrack = new MP3TrackImpl(new FileDataSourceImpl("/home/ubuntu/mpthreetest.mp3"));
        Movie m = new Movie();
        m.addTrack(myTrack);
        DefaultMp4Builder mp4Builder = new DefaultMp4Builder();
        Container out = mp4Builder.build(m);
        FileOutputStream fos = new FileOutputStream("output.mp4");
        FileChannel fc = fos.getChannel();
        out.writeContainer(fc);
        fos.close();
    }
}
