package com.aiworld.ragdocembedd.controller;


import com.aiworld.ragdocembedd.model.DocumentChunk;
import com.aiworld.ragdocembedd.service.ChunkingService;
import com.aiworld.ragdocembedd.service.DocumentService;
import com.aiworld.ragdocembedd.service.EmbeddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/rag")
public class RagController {


    @Autowired
    private DocumentService documentService;

    @Autowired
    private ChunkingService chunkingService;

    @Autowired
    EmbeddingService embeddingService;

    @PostMapping("/upload")
    public List<DocumentChunk> upload(@RequestParam MultipartFile file) {
        String text = documentService.extractText(file);       // STEP-2
        List<DocumentChunk> chunks = chunkingService.chunkText(text); // STEP-3
        return embeddingService.generateSingleEmbedding(chunks);   // STEP-4
    }
}
