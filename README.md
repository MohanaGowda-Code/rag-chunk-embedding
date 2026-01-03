# RAG Document Chunking & Embedding Service

This Spring Boot application is part of a **Retrieval-Augmented Generation (RAG)** pipeline.
It focuses on extracting text from documents, chunking it intelligently, and generating embeddings
(Mock-based for local development).

---

## Completed Steps

# STEP-1: Project Setup
- Spring Boot + Maven
- Clean package structure

### STEP-2: PDF & OCR
- Apache Tika for document parsing
- Tesseract OCR for scanned PDFs/images

### STEP-3: Text Chunking
- Sentence-aware chunking
- Max chunk size: 500 characters
- Overlap: 200 characters
- Output: `index + content`

### STEP-4: Embeddings (Mock)
- Deterministic mock embedding generator
- No OpenAI dependency (safe for local dev)
- Embeddings attached to each chunk
- Stored in in-memory vector store

---

## 📌 API

# Upload Document
POST /upload
**Form-Data**
- `file`: PDF / Image / Text file

# Response
```json
[
  {
    "index": 0,
    "content": "Extracted document text...",
    "embedding": [0.12, 0.89, 0.34, ...]
  }
]

## Architecture Flow
Document
 → OCR
 → Chunking
 → Embedding
 → Vector Store

## 👨‍💻 Author
**Mohana P**  
Senior Java & Microservices Engineer  
Exploring AI, RAG, and LLM integration with Spring Boot

